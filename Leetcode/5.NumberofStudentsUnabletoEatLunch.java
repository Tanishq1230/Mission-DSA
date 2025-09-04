class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] studentCounts = new int[2];
        for (int student : students) {
            studentCounts[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            int sandwich = sandwiches[i];

            if (studentCounts[sandwich] == 0) {
                return sandwiches.length - i;
            }
            studentCounts[sandwich]--;
        }
        return 0;
    }
}
