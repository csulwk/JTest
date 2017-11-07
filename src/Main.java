import add.MatlabJava;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class Main {

    public static void main(String[] args) throws MWException {

        //java调用matlab方法
        // matlab方法为[sum,m] = add(a,b)
        // java中方法为matlab实例的方法matlab.add(int,object...)，返回值为object[]
        // 其中输入的int为输出的个数，object...为输入参数，返回值object[]为输出的集合
        MatlabJava mj;//定义matlab类型
        try {
            mj = new MatlabJava();//实例化方法集合
            int[][] a = new int[][]{{1, 0}, {0, 1}};//定义输入参数
            int[][] b = new int[][]{{3, 2}, {1, 4}};//定义输入参数
            Object[] rs = mj.add(2, a, b);//调用方法1，方法1中调用方法2
            System.out.println("输出调用add方法的结果1：");
            System.out.println(rs[0]);
            MWNumericArray marr = (MWNumericArray) rs[0];//转为matlab格式矩阵
            System.out.println("输出第2行第2列数值：");
            System.out.println(marr.getInt(new int[]{2, 2}));
            System.out.println("输出调用add方法的结果2：");
            System.out.println(rs[1]);
            System.out.println("输出调用ims方法的结果：");
            System.out.println(mj.ims(1, 12, 3)[0]);//调用方法2
        } catch (MWException e) {
            e.printStackTrace();
        }

        System.out.println("----END----");
    }
}
