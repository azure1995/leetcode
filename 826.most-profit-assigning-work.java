class Solution {
    public class job {
        int d;
        int p;

        job(int difficulty, int profit) {
            this.d = difficulty;
            this.p = profit;
        }

    }

    Comparator<job> comp = new Comparator<job>() {
        public int compare(job j1, job j2) {
            if (j1.d != j2.d) {
                return j1.d > j2.d ? 1 : -1;
            } else {
                return j1.p > j2.p ? -1 : 1;
            }
        }
    };

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int num = difficulty.length;
        List<job> jobs = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            jobs.add(new job(difficulty[i], profit[i]));
        }
        Collections.sort(jobs, comp);
        List<Integer> selected_p = new ArrayList<>();
        List<Integer> selected_d = new ArrayList<>();
        selected_p.add(jobs.get(0).p);
        selected_d.add(jobs.get(0).d);
        for (int i = 1; i < num; i++) {
            if (jobs.get(i).p > selected_p.get(selected_p.size() - 1)) {
                selected_p.add(jobs.get(i).p);
                selected_d.add(jobs.get(i).d);
            }
        }
        int ret = 0;
        for (int i = 0; i < worker.length; i++) {
            int index = Collections.binarySearch(selected_d, worker[i]);
            if (index >= 0) {
                ret += selected_p.get(index);
            } else if (index < 0) {
                index = -index - 2;
                ret += index >= 0 ? selected_p.get(index) : 0;
            }
        }
        return ret;
    }
}
