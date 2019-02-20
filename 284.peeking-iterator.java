<<<<<<< HEAD
class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> it;
	Integer peekNum;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
		peekNum = it.hasNext() ? it.next() : null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return peekNum;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer ret = peekNum;
		peekNum = it.hasNext() ? it.next() : null;
		return ret;
	}

	@Override
	public boolean hasNext() {
		return peekNum == null ? false : true;
	}
=======
class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> it;
	Integer peekNum;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		it = iterator;
		peekNum = it.hasNext() ? it.next() : null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return peekNum;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer ret = peekNum;
		peekNum = it.hasNext() ? it.next() : null;
		return ret;
	}

	@Override
	public boolean hasNext() {
		return peekNum == null ? false : true;
	}
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}