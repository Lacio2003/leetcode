/**
 * 思路：经过思考，发现只要students中存在和sandwiches中相同的元素便可以进行移除
 * 知道不能够再移除为止。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(2*n)
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // 将数组中的元素存储到List集合当中
        List<Integer> listStudent = new ArrayList<>();
        List<Integer> listSandwiches = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            listStudent.add(students[i]);
            listSandwiches.add(sandwiches[i]);
        }

        // 获取sandwiches第一个位置在students集合当中的位置。
        int index = checked(listStudent, listSandwiches.get(0));

        // 如果students当中存在，说明sandwiches和students可以减少。
        while (index != -1) {
            // 将相同的元素移除
            listStudent.remove(index);
            listSandwiches.remove(0);

            // 如果长度为0，直接返回即可
            if (listStudent.size() == 0) {
                return 0;
            }
            // 再次进行判断
            index = checked(listStudent, listSandwiches.get(0));
        }
        return listStudent.size();
    }

    /**
     * 在students中寻找sandwiches第一个元素存在的下标。
     */
    private int checked(List<Integer> list, int key) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == key) {
                return i;
            }
        }

        return -1;
    }
}