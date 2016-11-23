package com.yyHaker.sort.base;

/**
 * BaseSort
 *
 *基本的排序算法，包括冒泡排序、选择排序、插入排序
 *
 * @author Le Yuan
 * @date 2016/11/23
 */
public class BaseSort {
    /**
     * 冒泡排序
     * 思想：每一轮从头开始两两比较，较大的数放在较小的数的右边，这样每轮下来就保证最大的数在最右边
     *
     * 算法分析：冒泡排序最好的情况是初始状态是正序的，一次扫描即可完成排序，所以最好的时间复杂度为O(N)；
     *      最坏的情况是反序的，此时最坏的时间复杂度为O(N^2)。平均情况，每轮N/2次循环，N轮时间复杂度为O(N^2)。
     *稳定性：算法是稳定，因为当a=b时，由于只有大于才做交换，故a和b的位置没有机会交换，所以算法稳定。
     *空间复杂度：空间复杂度为O(1)，不需要额外空间。
     *
     * @param source
     */
    public void bubbleSort(int[] source) {
        for(int i = source.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(source[j] > source[j+1])
                    swap(source, j, j+1); //交换
            }
        }
    }

    /**
     * 改进的冒泡排序
     * 思想：加入一个布尔变量标识该轮有没有进行数据的交换，若在某一次排序中未发现气泡位置的交换，
     * 则说明待排序的无序区中所有的项均已满足排序后的结果。
     * @param source
     */
    public void bubbleSort_exchange(int[] source) {
        boolean exchange;
        for(int i = source.length - 1; i > 0; i--) {
            exchange = false;
            for(int j = 0; j < i; j++) {
                if(source[j] > source[j+1]) {
                    swap(source, j, j+1);
                    exchange = true;
                }
            }
            if(!exchange) return;
        }
    }

    /**
     * 交换数据
     * @param source
     * @param m
     * @param n
     */
    public void swap(int [] source,int m,int n){
         int temp=source[m];
        source[m]=source[n];
         source[n]=temp;
    }

    /**
     * 选择排序
     * 思想：每一轮比较完后，把最小的放到最前的位置（或者把最大的放到最后）,需要n-1轮
     *
     * 算法分析：选择排序最好和最坏的情况一样运行了O(N2)时间，但是选择排序无疑更快，
     *    因为它进行的交换少得多，当N值较小时，特别是如果交换时间比比较时间大得多时，
     *     选择排序实际上是相当快的。平均复杂度也是O(N2)。
     * 稳定性：算法是不稳定的，假设a=b，且a在b前面，而某轮循环中最小值在b后面，
     *    而次最小值需要跟a交换，这时候b就在a前面了，所以选择排序是不稳定的。
     * 空间复杂度： 空间复杂度为O(1)，不需要额外的空间。
     * @param source
     */
    public void selectSort(int[] source) {
        int min;
        for(int i = 0; i < source.length; i++) {
            min = i;
            for(int j = i + 1; j < source.length; j++) {
                if(source[j] < source[min])
                    min = j;
            }
            swap(source,i, min);
        }
    }

    /**
     * 插入排序
     * 思想：插入排序的实现步骤为：从第一个元素开始，该元素可以认为已经被排序
     *    ->取出下一个元素，在已经排序的元素序列中从后向前扫描
     *    -> 如果该元素小于前一个元素，则将两者调换，再与前一个元素比较
     *    –> 重复第三步，直到找到已排序的元素小于或者等于新元素的位置
     *    -> 将新元素插入到该位置中
     *    -> 重复第二步
     *
     * 算法分析：算法分析：插入排序最好的情况是序列已经是升序排列了，在这种情况下，
     *   需要进行N-1次比较即可，时间复杂度为O(N)，最坏的情况是序列降序排列，这时候
     *   时间复杂度为O(N^2)。因此插入排序不适合对于数据量比较大的排序应用。但是如果
     *   需要排序的数据量很小(如小于千)，那么插入排序还是一个不错的选择。插入排序平均
     *   时间复杂度为O(N^2)，但是它要比冒泡排序快一倍，比选择排序还要快一点，经常被
     *   用在较复杂的排序算法的最后阶段，例如快速排序。
     * 算法稳定性: 算法是稳定的，假设a=b，且a在b的前面，其排序位置必然比b先确定，而后
     *   面再插入b时，必然在a的后面，所以是稳定的。
     * 空间复杂度：空间复杂度为O(1)，不需要额外的空间。
     * @param source
     */
    public void insertSort(int[] source) {
        for(int i = 1; i < source.length; i++) {
            for(int j = i; (j > 0) && (source[j] < source[j-1]); j--) {
                swap(source,j, j-1);
            }
        }
    }

    /**
     * 希尔排序
     * 思想：将数据进行分组，然后对每一组数据进行插入排序，在每一组数据都有序后，
     *   再对所有的分组利用插入排序进行最后一次排序。这样可以显著减少数据交换的次数，
     *   以达到加快排序速度的目的。
     *   这种思想需要依赖一个增量序列，我们称为n-增量，n表示进行排序时数据项之间的间隔，习惯上用h表示。
     *   增量序列在希尔排序中是很重要的。一般好的增量序列都有2个共同的特征：
     *         1. 最后一个增量必须为1，保证最后一趟是一次普通的插入排序；
     *        2. 应该尽量避免序列中的值（尤其是相邻的值）互为倍数的情况
     *    增量序列用 h = 3 * h + 1来生成。h初值被赋予1，然后使用该公式生成序列1、4、13、40、121、364等等，
     *    当间隔大于数组大小的时候停止，使用序列的最大数组作为间隔开始希尔排序过程，然后没完成一次排序，
     *    用倒推公式 h = (h - 1) / 3来减小间隔，保证最后一次h=1，完成最后一次插入排序。
     *
     * 算法分析：希尔排序时间复杂度平均为O(NlogN)，最好与最坏情况要根据具体的增量序列来判断，对于不同的
     *    增量序列有不同的复杂度。希尔排序的性能优于直接插入排序，因为在希尔排序开始时增量较大，分组较多，
     *    每组的记录数目少，故各组内直接插入较快，后来随着增量逐渐缩小，分组数逐渐减少，而各组的记录数目逐渐
     *   增多，但是由于已经局部排过序了，所以已经接近有序状态，新的一趟排序过程也较快。因此，希尔排序在效率
     *   上较直接插入排序有较大的改进
     * 稳定性：希尔排序是不稳定的，因为不同的间隔对应的数据是独自比较的，如果a=b，但是不在同一个间隔上，
     *    显然会出现前后颠倒的情况，所以希尔排序是不稳定的。
     *空间复杂度：空间复杂度为O(1)，不需要额外的存储空间。
     */
    public void shellSort2(int []source,int nElem) {
        int h = 1;
        while(h <= nElem / 3) {
            h = h * 3 + 1; //增量间隔
        }

        while(h > 0) {
            for(int i = h; i < nElem; i++) {
                //每个增量间隔内，实现插入排序，两个for循环和插入排序一样，只不过第二个for循环里参数略有调整而已，和h有关
                for(int j = i; j < nElem; j += h) {
                    for(int k = j; (k - h >= 0) && source[k] < source[k - h]; k -= h) {
                        swap(source,k, k-h);
                    }
                }
            }
            h = (h-1) / 3;
        }
    }

}
