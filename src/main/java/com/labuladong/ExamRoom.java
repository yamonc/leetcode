package com.labuladong;

import java.util.TreeSet;

/**
 * @Author yamon
 * @Date 2021-07-09 15:09
 * @Description 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 *  
 *
 * 示例：
 *
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ExamRoom {
    int N;
    TreeSet<Integer> students;
    public ExamRoom(int n) {
        this.N = n;
        students = new TreeSet<>();
    }

    public int seat() {
        //首先确定学生的下一个位置
        int student = 0;
        if(students.size()>0){
            //暂定定义dist是到最近学生的距离，
            // 这是通过坐在“学生”位置来实现的。
            // 我们首先考虑最左边的座位
            int dist = students.first();
            Integer prev = null;
            for(Integer s:students){
                if(prev!=null){
                    //对于位置 (prev, s) 的每对相邻学生
                    //d 是到最近学生的距离
                    //在位置 prev + d 处实现。
                    int d = (s-prev)/2;
                    if(d>dist){
                        dist = d;
                        student = prev+d;
                    }
                }
                prev=s;
            }
            //考虑最右边的位置
            if(N-1- students.last() > dist){
                student=N-1;
            }

        }
        //将学生添加到我们排序的位置树集
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }

    public static void main(String[] args) {
        final ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }
}
