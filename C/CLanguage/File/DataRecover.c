
/*--------------------------------------------------------------------------------------
LBR���ĸ�������a,b,c,d���������ĸ����ֹ�����һ��3*3����

a	b	a+b
c	d	c+d
a+c	b+d	a+b+c+d

����ʵ���ҵ�ĳ��diaoren͵͵�����˾����еļ������֣�������Ҫ�����ʣ�µ����ֻ�ԭ��������

��һ������һ������T(T<=12800)��������������
�����������ÿ�����ݰ���һ��3*3�ľ���
0������ȥ������

����ÿ������
������Ը�ԭ���󣬵�һ�����"YES"�����������������ԭ��ľ���  
�������һ��"NO"

��������#:
3
2 3 0
5 7 0
0 0 0
0 0 5
0 0 12
7 10 17
0 3 5
0 0 0
0 10 17
�������#:
YES
2 3 5
5 7 12
7 10 17   
NO
YES
2 3 5
5 7 12
7 10 17
--------------------------------------------------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>

int Check(int ma[3][3]);

int main()
{
    int ma[12800][3][3] = {0};        //enough for fives
    int n=0;      //how much data group
    int i=0,j=0;
    
    scanf("%d",&n);
    for(i=0;i<n;i++)
          for(j=0;j<3;j++)
              scanf("%d %d %d",&ma[i][j][0], &ma[i][j][1], &ma[i][j][2]);


    // int me[3][3] = 
    // {   {2,2,4},
    //     {0,2,0},
    //     {0,0,0},
    // }; 
    for(i=0;i<n;i++)
        Check(ma[i]);
    return 0;
}

int Check(int ma[3][3])     //�жϾ����ܷ�ԭ
{
    for(int j=0;j<3;j++)        //����У������
        if(ma[j][2] == 2) ma[j][0] = ma[j][1] = 1;
        else if (ma[j][0] && ma[j][1]) ma[j][2] = ma[j][0] + ma[j][1];
        else if (ma[j][0] && ma[j][2]) ma[j][1] = ma[j][2] - ma[j][0];
        else if (ma[j][1] && ma[j][2]) ma[j][1] = ma[j][2] - ma[j][1];
    for(int j=0;j<3;j++)        //����У������
        if(ma[2][j] == 2) ma[0][j] = ma[1][j] = 1;
        else if (ma[0][j] && ma[1][j]) ma[2][j] = ma[0][j] + ma[1][j];
        else if (ma[0][j] && ma[2][j]) ma[1][j] = ma[2][j] - ma[0][j];
        else if (ma[1][j] && ma[2][j]) ma[0][j] = ma[2][j] - ma[1][j];
    for(int j=0;j<3;j++)        //�ٴκ���У������
        if(ma[j][2] == 2) ma[j][0] = ma[j][1] = 1;
        else if (ma[j][0] && ma[j][1]) ma[j][2] = ma[j][0] + ma[j][1];
        else if (ma[j][0] && ma[j][2]) ma[j][1] = ma[j][2] - ma[j][0];
        else if (ma[j][1] && ma[j][2]) ma[j][1] = ma[j][2] - ma[j][1];

    int mark = 1;   //������� 0 ˵����ԭ����
    for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
            if(!ma[i][j])
            {
                mark = 0;
                break;
            }

    if(mark)
    {
        printf("YES\n");
        for(int i=0;i<3;i++)
            printf("%d %d %d\n",ma[i][0], ma[i][1], ma[i][2]);
    }
    else printf("NO\n");

}

