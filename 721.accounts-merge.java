class Solution {
    int global_id = 0;

    public int getRoot(Map<Integer, Integer> roots, int id) {
        int root = id;
        while (root != roots.get(root)) {
            root = roots.get(root);
        }
        while (id != roots.get(id)) {
            int next = roots.get(id);
            roots.put(id, root);
            id = next;
        }
        return root;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, String> names = new HashMap<>();
        Map<String, Integer> ids = new HashMap<>();
        Map<Integer, Integer> roots = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = -1;
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!ids.containsKey(email)) {
                    ids.put(email, global_id);
                    roots.put(global_id, global_id);
                    global_id++;
                }
                int id = ids.get(email);
                if (j == 1) {
                    names.put(id, accounts.get(i).get(0));
                    root = getRoot(roots, id);
                } else {
                    int r = getRoot(roots, id);
                    roots.put(r, root);
                }
            }
        }
        Map<Integer, SortedSet<String>> helper = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int r = getRoot(roots, ids.get(accounts.get(i).get(1)));
            if (!helper.containsKey(r)) {
                helper.put(r, new TreeSet<>());
            }
            for (int j = 1; j < accounts.get(i).size(); j++) {
                helper.get(r).add(accounts.get(i).get(j));
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<Integer, SortedSet<String>> e : helper.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(names.get(e.getKey()));
            list.addAll(e.getValue());
            ret.add(list);
        }
        return ret;
    }
}
