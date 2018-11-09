public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> it;
    NestedIterator inner = null;
    Integer nextInteger;

    public NestedIterator(List<NestedInteger> nestedList) {
        it = nestedList.iterator();
    }

    @Override
    public Integer next() {
        return nextInteger;
    }

    @Override
    public boolean hasNext() {
        if (inner != null && inner.hasNext()) {
            nextInteger = inner.next();
            return true;
        }
        while (it.hasNext()) {
            NestedInteger nextNestedInteger = it.next();
            if (nextNestedInteger.isInteger()) {
                nextInteger = nextNestedInteger.getInteger();
                return true;
            } else {
                inner = new NestedIterator(nextNestedInteger.getList());
                if (inner.hasNext()) {
                    nextInteger = inner.next();
                    return true;
                }
            }
        }
        return false;
    }
}