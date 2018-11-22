class MyCalendar {
    Map<Integer, Integer> map;
    List<Integer> events;

    public MyCalendar() {
        map = new HashMap<>();
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (start < end && !map.containsKey(start)) {
            int index = Collections.binarySearch(events, start);
            index = -index - 1;
            if (index < events.size() && events.get(index) < end) {
                return false;
            }
            if (index > 0 && map.get(events.get(index - 1)) > start) {
                return false;
            }
            map.put(start, end);
            events.add(index, start);
            return true;
        }
        return false;
    }
}