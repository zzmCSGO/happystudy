package com.zzm.hot100.forty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-02-02  19:29
 * @Description: TODO
 * @Version: 1.0
 */
//37.解数独
public class ThirtySeven {
    public static void main(String[] args) {

    }
    //1.不断遍历每个未填的空格，逐一尝试1~9 若行，列九宫格内没有冲突，则填入
    //2.一旦1~9都尝试失败，回溯到上一个状态，换数字填入
    //3.关键还是要记录冲突状态
    public void solveSudoku(char[][] board) {
        //行冲突状态
        //row[i]={false,false,false,false,false,false,false,false,false}
        boolean[][] row=new boolean[9][9];
        //列冲突状态  1是冲突的
        //col[i]={true,false,false,false,false,false,false,false,false}
        boolean[][] col=new boolean[9][9];
        //九宫格冲突状态
        //block[i/3*3+j/3]={false,false,false,false,false,false,false,false,false}
        boolean[][] block=new boolean[9][9];
        //初始化
        for(int i=0;i<9;i++){//行
            for(int j=0;j<9;j++){//列
                char ch=board[i][j];
                if(ch!='.'){
                    //初始化冲突状态
                    row[i][ch-'1']=true;//第i行的数字5冲突，则索引是4
                    col[j][ch-'1']=true;
                    block[i/3*3+j/3][ch-'1']=true;//i/3*3+j/3个单元格的数字5冲突，则索引是4
                }
            }
        }
        dfs(0,0,board,row,col,block);

    }

    static boolean dfs(int i,int j,char[][]table,boolean[][]row,boolean[][]col,boolean[][]block){

        //若table[i][j]为空格，则不会走while循环
        while(table[i][j]!='.'){//查找下一个空格
            if(++j>=9){
                //该行空格找完，去下一行找
                j=0;//列重置
                i++;
            }
            if(i>=9){
                return true;//找到解
            }
        }

        //填空
        for (int k = 1; k <= 9; k++) {
            //检查冲突
            if(row[i][k-1]||col[j][k-1]||block[i/3*3+j/3][k-1]){
                continue;
            }
            //填入数字
            table[i][j]=(char)(k+'0');//变成字符

            //记录冲突
            //row[0][0]=true 第0行不能存储’1‘
            row[i][k-1]=true;
            //
            col[j][k-1]=true;
            //block[0][0]=true 第0个单元格不能存储’1‘
            block[i/3*3+j/3][k-1]=true;
            if(dfs(i,j,table,row,col,block)){
                return true;
            }
            //回溯
            table[i][j]='.';
            row[i][k-1]=false;
            col[j][k-1]=false;
            block[i/3*3+j/3][k-1]=false;
        }
        return false;

    }
}
