package catcafe;

import static java.util.Objects.requireNonNull;

import java.util.Optional;
import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    public long getCatCount() {
        return clowder.size();
    }

    public FelineOverLord getCatByName(String name) {
        if (name == null) return null;

        for (FelineOverLord c : clowder) {
            if (c.name().equals(name)) return c;
        }

        return null;
    }

    public Optional<FelineOverLord> getCatByWeight(int minWeight, int maxWeight) {
        if (minWeight < 0) throw new NullPointerException("The provided minWeight is less than 0");
        if (maxWeight < minWeight)
            throw new NullPointerException(
                    "The provided minWeight is greater than the provided maxWeight");

        return clowder.stream()
                .filter(c -> c.weight() >= minWeight && c.weight() < maxWeight)
                .findFirst();
    }

    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }
}
