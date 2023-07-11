package programs

import java.util.*

fun main() {
    merge(intArrayOf(-1,0,0,3,3,3,0,0,0),6, intArrayOf(1,2,2),3)
    merge(intArrayOf(1,2,3,0,0,0),3, intArrayOf(2,5,6),3)
    merge(intArrayOf(2, 5, 6, 0, 0, 0), 3, intArrayOf(1, 2, 3), 3)
    merge(intArrayOf(1), 1, intArrayOf(), 0)
    merge(intArrayOf(0), 0, intArrayOf(1), 1)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    if (nums2.isEmpty()) {
        return
    }

    //val queue = PriorityQueue<Int>()
    val queue = ArrayDeque<Int>()
    var nums2Pointer = 0

    for (i in nums1.indices) {

        if (queue.isEmpty() && nums1[i] == 0 && i>=m) {
            nums1[i] = nums2[nums2Pointer]
            nums2Pointer++
            continue
        }

        val elementFromQueue = queue.peek()
        val ele1 = elementFromQueue ?: nums1[i]

        var ele2: Int

        ele2 = if (nums2Pointer > nums2.lastIndex) {
            ele1
        } else {
            nums2[nums2Pointer]
        }


        if (ele1 <= ele2) {

            //Taking element from queue, and before updating value in nums1, store the
            //current value in queue
            if (elementFromQueue != null) {

                if (i < m) {
                    queue.add(nums1[i])
                }

                nums1[i] = ele1
                queue.poll()
            }
        } else {
            if (i < m) {
                queue.add(nums1[i])
            }
            nums1[i] = ele2
            nums2Pointer++
        }

    }

    println(nums1.contentToString())
}