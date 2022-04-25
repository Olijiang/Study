#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 30    //���ѧ������

//ѧ���ɼ�����ϵͳ
//Ctrl+k+0  �۵����д���


typedef struct data
{
    int year;
    int month;
    int day;
}DATA;

typedef struct student
{
    long ID;          //ѧ��
    char Name[10];    //����
    char Sex;         //�Ա�
    DATA Birth;       //����
    int Core[4];      //s���ſγ̵ĳ���ɼ�
    float aver;       //ƽ���ɼ�
    int total;
}STUDENT;

void Init();                        //��ʼ��ѧ������
void Show(int m, int n);            //��ӡѧ����Ϣ
void WriteFile();                   //���ձ�������д����
void ReadFile();    
void WriteFile1();                  //�������ݿ��д����
void ReadFile1();
void Cue();                         //��ӡ��ʾ��Ϣ
int GetChoice();                    //��ȡ����
void Operate(int d);                //��������
void AddStuent();                   //��Ӽ�¼
void ClearBar();                    //��ջ�����
int CheckName(char name[]);         //������ֺϷ��ԣ�ֻ֧�ֺ���
int CheckBirDay(int year, int month, int day);      
int CheckScore(int a, int b, int c, int d);
int CheckID(int id);                //���ID�Ϸ���
void CauSByCo();                    //ͳ��ÿ��Course��ƽ����
void SortByStA(int low, int high);  //��Student�ܳɼ� ���� ����
void SortByStB(int low, int high);  //��Student�ܳɼ� ���� ����
void SortByID(int low, int high);
void SortByName(int low, int high);
int SearchByID(int id);              //��ID����
int SearchByName(char Name[]);
void ModifyRecord();    //�޸�ѧ����Ϣ
void Deleterecord();


int Sn=-1;     //��ǰѧ������
int Cgfg=0;      //�޸ı�Ƿ������������û��˳�ʱ����
STUDENT Sw[N];  //ѧ��Ⱥ��


int main()
{
    
    ReadFile1();
    Cue();
    int d = GetChoice();
    
    while (1)
    {
        Operate(d);
        d = GetChoice();
    }
    
    //Init(Sw);
    return 0;
}

void Cue()
{
    printf("\n");
    printf("* * * * * * * * * * *Score Management System 1.0 * * * * * * * * * *\n");
    printf("*  1.List ALL                                                      *\n");
    printf("*  2.Caculate average score of every course                        *\n");
    printf("*  3.Sort in descending order by total score of every student      *\n");
    printf("*  4.Sort in ascending order by total score of every student       *\n");
    printf("*  5.Sort in ascending order by ID number                          *\n");
    printf("*  6.Sort in ascending order by name                               *\n");
    printf("*  7.Serch by ID number                                            *\n");
    printf("*  8.Serch by name                                                 *\n");
    printf("*  9.Delete record                                                 *\n");
    printf("*  10.Add student record                                           *\n");
    printf("*  11.Save to file                                                 *\n");
    printf("*  12.Change record                                                *\n");
    printf("*  0.Exit                                                          *\n");
    printf("* * * * * * * * * * * * * * * END UP * * * * * * * * * * * * * * * *\n");
}

int GetChoice()   //��ʾ��Ϣ  
{
    int d=-1;
AD: printf("\n> > > > Please enter your chioce(Input 99 get help): ");
    scanf("%3d",&d);
    ClearBar();
    if (d==0)
    {
        if (Cgfg)
        {
            printf("record has been changed but not be saved, do you want to save and exit?(Y or y):");
            char c = getchar();
            if (c=='Y' || c=='y')
            {
                WriteFile1(Sw);
                exit(0);
            }
            else exit(0);
        }
        else exit(0);
    }
    while (d<0 || d>12)
    {
        if(d==99)
        {
            Cue();
            goto AD;
        } 
        else
        {
            printf("! ! * * * Invaild Input * * * ! !\n");
            goto AD;
        }
    }
    return d;
}

void Operate(int d)     //�����û�ѡ��ִ�й���
{
    switch (d)  
    {
        case 0: exit(0);
        case 1:
            Show(0, Sn);
            break;
        case 2:
            CauSByCo();//ͳ��ÿ��Course�� ƽ����
            break;
        case 3:
            SortByStB(0, Sn-1);//��Student�ܳɼ� ���� ����
            printf("\nSort in descending order by total score of every student are as follows:");
            Show(0, Sn);
            break;
        case 4:
            printf("\nSort in ascending order by total score of every student are as follows:");
            SortByStA(0, Sn-1);//��Student�ܳɼ� ���� ����
            Show(0, Sn);
            break;
        case 5:
            printf("\nSort in ascending order by ID number are as follows:");
            SortByID(0, Sn-1);
            Show(0, Sn);
            break;
        case 6:
            printf("\nSort in ascending order by name are as follows:");
            SortByName(0, Sn-1);
            Show(0, Sn);
            break;
        case 7:
            printf("> > > >Please input ID number(4 Width):");
            int gid;
            scanf("%5d", &gid);
            ClearBar();
            int a = SearchByID(gid);
            if(a!=-1) Show(a,a+1);
            break;
        case 8:
            printf("> > > >Please input Name:");
            char gname[10];
            scanf("%10s", gname);
            ClearBar();
            SearchByName(gname);
            break;
        case 9:
            Deleterecord();
            break;
        case 10:
            AddStuent();//��Ӽ�¼
            break;
        case 11:
            printf("Are you sure wirte to file?(Y Or N)");
            char c = getchar();
            ClearBar();
            if (c=='Y' || c=='y') WriteFile1();
            break;
        case 12:
            ModifyRecord();
            break;
        default:
            break;
    }
}

void Init()//��ʼ��һЩѧ��
{
    Sn=5;
    int StID[5] = {2012, 3013, 4014, 5015, 6016};
    char StName[5][10] = {"����", "ǧӰ", "����", "ѩ��", "�޼�"}; //��c�����У��ַ���������˫����������,  �������õ����ţ������ű�ʾ���ǵ����ַ�
    char StSex[5] = {'F', 'F', 'F', 'F', 'F'};
    int StBirth[5][5] = {{1999,2,6},{1999,5,13},{1998,5,20},{1999,2,28},{1999,3,13}};
    int Stcore[5][4] = {{80,99,86,97},{83,97,90,96},{90,85,97,91},{92,93,89,82},{91,89,95,94}};
    int i;
    for (size_t i = 0; i < 5; i++)
    {
        Sw[i].ID = StID[i];
        strcpy(Sw[i].Name, StName[i]);
        Sw[i].Sex = StSex[i];
        Sw[i].Birth.year = StBirth[i][0];
        Sw[i].Birth.month = StBirth[i][1];
        Sw[i].Birth.day = StBirth[i][2];
        Sw[i].Core[0] = Stcore[i][0];
        Sw[i].Core[1] = Stcore[i][1];
        Sw[i].Core[2] = Stcore[i][2];
        Sw[i].Core[3] = Stcore[i][3];
        Sw[i].total = Sw[i].Core[0]+Sw[i].Core[1]+Sw[i].Core[2]+Sw[i].Core[3];
        Sw[i].aver = (float)Sw[i].total/4;
    }
    WriteFile1();
    printf("\n--------------------------------------- initialize successfully ------------------------------------\n");
}

void Show(int m, int n)//��ӡ�� m ������ n ��ѧ������Ϣ
{   
    printf("\n---------------------------------------------- Begain ----------------------------------------------\n");
    if (m==0)
    {
        printf("Members:%d\n", Sn);
    }
    for (size_t i = m; i < n; i++)
    {
        printf("ID:%-6d", Sw[i].ID);//-��ʾ����������
        printf("Name:%-10s", Sw[i].Name);
        printf("Sex:%-3c", Sw[i].Sex);
        printf("BirthDay:%-4d/%02d/%02d ", Sw[i].Birth.year, Sw[i].Birth.month, Sw[i].Birth.day);
        printf(" Score:%-4d%-4d%-4d%-4d", Sw[i].Core[0], Sw[i].Core[1], Sw[i].Core[2], Sw[i].Core[3]);
        printf(" Average:%-6.1f", Sw[i].aver);
        printf("Total:%-3d\t", Sw[i].total);
        printf("\n");
    }
    printf("------------------------------------------------ END -----------------------------------------------\n");
}

void WriteFile1()//fwriteд�룬�����ݿ�д�룬�������ļ������ɲ鿴
{   
    FILE *fp;
    if ((fp=fopen("score.bin","wb"))==NULL)
    {
        printf("\n--------------------------------------- write to file filed ----------------------------------------\n");
        exit(0);
    }
    fwrite(&Sn, sizeof(int), 1, fp);
    fwrite(Sw, sizeof(STUDENT), Sn, fp);
    printf("\n----------------------------------------- Write Successfully ---------------------------------------\n");
    fclose(fp);
    Cgfg = 0;    //
}

void ReadFile1()//fwrite��ȡ
{ 
    FILE *fp;
    if ((fp=fopen("score.bin","rb"))==NULL)
    {
        printf("\n------------------ File score.bin is not exist, now will create and initialize it ------------------\n");
        Init();
        return;
    }

    fread(&Sn, sizeof(int), 1, fp);
    if (Sn==-1)
    {
        printf("read file error!\n");
        system("pause");
        exit(0);
    }
    printf("\n------------------------------- Read data from score.bin successfully ------------------------------\n");
    for (size_t i = 0;!feof(fp); i++)
    {
        fread(&Sw[i], sizeof(STUDENT), 1, fp);
    }
    fclose(fp);
}

void AddStuent()//���ѧ����Ϣ
{
    int flag=1;//1��ʾ���ݺϷ���0��ʾ���ݲ��Ϸ�
Name:printf("> > > >Please Input Name(Must be Chinese): ");
    scanf("%10s",&Sw[Sn].Name);
    ClearBar();
    flag = CheckName(Sw[Sn].Name);
    if (!flag)
    {
        if(Sw[Sn].Name[0] == '0')
        {
            printf("\n-------------------------------------- Add Failed --------------------------------------------------\n");
            return;
        }
        printf("\nWarning ---- Vaild Input -------- Name Only Support Chinese --------- or Input 0 to exit -----------\n");
        goto Name;
    }
    
ID: printf("> > > >Please Inout ID(4 lenth): ");
    scanf("%5d",&Sw[Sn].ID);
    ClearBar();
    flag = CheckID(Sw[Sn].ID);
    if (!flag)
    {
        if(Sw[Sn].ID == 0)
        {
            printf("\n-------------------------------------- Add Failed --------------------------------------------------\n");
            return;
        } 
        printf("\nWarning ---- Vaild Input -------- ID Only Support 4 numbers --------- or Input 0 to exit -----------\n");
        goto ID;
    }

Sex:printf("> > > >Please Inout Sex(M or F): ");
    scanf(" %1c",&Sw[Sn].Sex);
    ClearBar();
    flag = (Sw[Sn].Sex=='M' || Sw[Sn].Sex=='F')?(1):(0);
    if (!flag)
    {
        if(Sw[Sn].Sex == '0')
        {
            printf("\n-------------------------------------- Add Failed --------------------------------------------------\n");
            return;
        }
        printf("\nWarning ---- Vaild Input -------- Sex Only Support M(Male) or F(female) --- or Input 0 to exit -----\n");
        goto Sex;
    }

BDay:printf("> > > >Please Inout BirthDay(1990~2010 For:19990526): ");
    scanf("%4d%2d%2d",&Sw[Sn].Birth.year, &Sw[Sn].Birth.month, &Sw[Sn].Birth.day);
    ClearBar();
    flag = CheckBirDay(Sw[Sn].Birth.year, Sw[Sn].Birth.month, Sw[Sn].Birth.day);
    if (!flag)
    {
        if(0 == Sw[Sn].Birth.year == Sw[Sn].Birth.month == Sw[Sn].Birth.day ) //ȫ��Ϊ0��Ϊ���ʽֵΪ1
        {
            printf("\n-------------------------------------- Add Failed --------------------------------------------------\n");
            return;
        }
        printf("\nWarning -- Vaild Input ---- BirthDay Only be Allowed in 1990 to 2010 --- or Input eight 0 to exit --\n");
        goto BDay;
    }

Score:printf("> > > >Please Input Score for 4 course(1~100 For:98 98 98 98): ");
    scanf("%3d %3d %3d %3d",&Sw[Sn].Core[0], &Sw[Sn].Core[1], &Sw[Sn].Core[2], &Sw[Sn].Core[3]);
    ClearBar();
    flag = CheckScore(Sw[Sn].Core[0], Sw[Sn].Core[1], Sw[Sn].Core[2], Sw[Sn].Core[3]);
    if (!flag)
    {
        if(0 == Sw[Sn].Core[0] == Sw[Sn].Core[1] == Sw[Sn].Core[2] == Sw[Sn].Core[3])//ȫ��Ϊ0ʱΪ���ʽֵΪ1
        {
            printf("\n-------------------------------------- Add Failed --------------------------------------------------\n");
            return;
        }
        printf("\nWarning ---- Vaild Input -------- Score Only be Allowed in 1 to 100 ---- or Input eight 0 to exit --\n");
        goto Score;
    }

    Sw[Sn].total = Sw[Sn].Core[0]+Sw[Sn].Core[1]+Sw[Sn].Core[2]+Sw[Sn].Core[3];
    Sw[Sn].aver = (float)Sw[Sn].total/4;
    Sn = Sn + 1;
    Cgfg = 1;
    printf("\n------------------------------------- Add Successfully ---------------------------------------------\n");
}

void CauSByCo() //ͳ��ÿ��Course��ƽ����
{
    float aver[4]={0};
    for (size_t i = 0; i < Sn; i++)
    {
        aver[0] += (float)Sw[i].Core[0]/Sn;
        aver[1] += (float)Sw[i].Core[1]/Sn;
        aver[2] += (float)Sw[i].Core[2]/Sn;
        aver[3] += (float)Sw[i].Core[3]/Sn;
    }
    printf("\n---------------------------------------------- Begain ----------------------------------------------\n");
    printf("--->Course_1: %.2f\n", aver[0]);
    printf("--->Course_2: %.2f\n", aver[1]);
    printf("--->Course_3: %.2f\n", aver[2]);
    printf("--->Course_4: %.2f\n", aver[3]);
    printf("------------------------------------------------ END -----------------------------------------------\n");
}

void SortByStA(int low, int high)//��Student�ܳɼ� ���� ����
{
    if (low>=high) return;
    STUDENT temp; 
	int L = low, H = high;
	temp = Sw[L];
	while(L<H)
	{
		while(L<H && Sw[H].total>=temp.total) --H;  
		Sw[L] = Sw[H];	
		while(L<H && Sw[L].total<temp.total) ++L;	
		Sw[H] = Sw[L];
	}
	Sw[L] = temp;
	SortByStA(low, L-1);
	SortByStA(L+1, high);
}

void SortByStB(int low, int high)//��Student�ܳɼ� ���� ����
{
    if (low>=high) return;
    STUDENT temp; 
	int L = low, H = high;
	temp = Sw[L];
	while(L<H)
	{
		while(L<H && Sw[H].total<=temp.total) --H;  
		Sw[L] = Sw[H];	
		while(L<H && Sw[L].total>temp.total) ++L;	
		Sw[H] = Sw[L];
	}
	Sw[L] = temp;
	SortByStB(low, L-1);
	SortByStB(L+1, high);
}

void SortByID(int low, int high)
{
    if (low>=high) return;
    STUDENT temp; 
	int L = low, H = high;
	temp = Sw[L];
	while(L<H)
	{
		while(L<H && Sw[H].ID>=temp.ID) --H;  
		Sw[L] = Sw[H];	
		while(L<H && Sw[L].ID<temp.ID) ++L;	
		Sw[H] = Sw[L];
	}
	Sw[L] = temp;
	SortByID(low, L-1);
	SortByID(L+1, high);
}

void SortByName(int low, int high)
{
    if (low>=high) return;
    STUDENT temp;           //a = strcmp(nn,na);a<0, str1>str2, ��Ϊ���ֵı����Ǹ������Ժ��ַ��ıȽ��෴
    int flag = 0;
	int L = low, H = high;
	temp = Sw[L];
	while(L<H)
	{
		while(L<H && strcmp(Sw[H].Name,temp.Name)>=0) --H;  
		Sw[L] = Sw[H];	
		while(L<H && strcmp(Sw[H].Name,temp.Name)<0) ++L;	
		Sw[H] = Sw[L];
	}
	Sw[L] = temp;
	SortByName(low, L-1);
	SortByName(L+1, high);
    
}

void ClearBar()//������뻺����
{
    char c;
    while ((c = getchar()) != EOF && c != '\n');
}

int CheckName(char a[])//��������Ƿ��Ǻ����ҳ��Ȳ�����4����
{   //���ֵı���С��0
    int n = strlen(a);
    if(n>8) return 0;
    for (size_t i = 0; i < n; i++)
    {
        if (a[i]>0) return 0;
    }
    return 1;
}

int CheckBirDay(int year, int month, int day)   //������պϷ���
{
    if (year<1990 || year>2010) return 0;
    if (month<0 || month>12) return 0;
    switch (month)
    {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (day<0 || day>31) return 0;
            break;
        case 2:
            if (((year%100!=0) && (year%4==0)) || (year % 400==0))//����
            {
                if (day<0 || day>29) return 0;//������������������if��������else��ԣ�Ҳ������һ��else������߼�����
            }
            else
                if (day<0 || day>28) return 0;
            break;
        default:
            if (day<0 || day>30) return 0;
            break;
    }
    return 1;
}

int CheckScore(int a, int b, int c, int d)
{
    return (a>0&&a<101&&b>0&&b<101&&c>0&&c<101&&d>0&&d<101)?(1):(0);
}

int CheckID(int id)
{
    if (id<999 || id>10000) return 0;
    for (size_t i = 0; i < Sn; i++)
    {
        if (id==Sw[i].ID) 
        {
            printf("\n------------------------------------- The ID has been used -----------------------------------------\n");
            return 0;
        }
    }
    return 1;
}

int SearchByID(int id)   //��ID����,�����ڣ����������±�,�޷���-1
{
    if (id<999 || id>10000)
    {
        printf("\nWarning------------------------------------- Invalid ID --------------------------------------------\n");
        return -1;
    }
    int a=-1;
    for (size_t i = 0; i < Sn; i++)
    {
        a++;
        if (id==Sw[i].ID)
            return a;

    }
    printf("\n--------------------------------------- Not found ID %d --------------------------------------------\n",id);
    return -1;
}

int SearchByName(char Name[])
{
    int n = strlen(Name);//Name�ֽڳ��ȣ�һ�����������ֽ�
    if(n>8)
    {
        printf("Warning---------------------------------- Name is to long ------------------------------------------");
        return 0;
    }
    for (size_t i = 0; i < n; i++)
    {
        if (Name[i]>0)
        {
            printf("\nWarning----------------------------------- Invalid Name -------------------------------------------\n");
            return 0;
        }
    }
    int a=-1;
    for (size_t i = 0; i < Sn; i++)
    {
        a++;
        if (strcmp(Name,Sw[i].Name)==0)
        {
            Show(a,a+1);
            return 1;
        }
    }
    printf("\n--------------------------------------- Not found Name %s --------------------------------------------\n",Name);
    return 0;
}





void ModifyRecord()
{
    int gID;
    printf("> > > >Please input the ID number to be modified: ");
    scanf("%5d",&gID);
    ClearBar();
    int a = SearchByID(gID);
    if (a==-1) return;     //ID������ֱ�ӷ���
CH: printf("> > > >Please chose the options you want to modify(1.Name 2.ID 3.Sex 4.BirthDay 5.Score 0.exit): ");
    char c = getchar();
    ClearBar();
    if (c=='0') return;
    if (c<'1' && c>'5') goto CH;
    //���ڽ�������Ϣ�ı���
    char newname[10];
    int newID;
    char newSex;
    int year, month, day;
    int c1,c2,c3,c4;

    int flag=1;//1��ʾ���ݺϷ���0��ʾ���ݲ��Ϸ�
    switch (c)
    {
        case '1':
        CName:printf("> > > >Please Input New Name(Must be Chinese): ");
            scanf("%10s",&newname);
            ClearBar();
            flag = CheckName(newname);
            if (!flag)
            {
                if(newname[0] == '0')
                {
                    printf("\n-------------------------------------- modify Failed -----------------------------------------------\n");
                    goto CH;
                }
                printf("\nWarning ---- Vaild Input -------- Name Only Support Chinese --------- or Input 0 to Reselect -------\n");
                goto CName;
            }
            strcpy(Sw[a].Name, newname);
            Cgfg = 1;
            printf("\n------------------------------------- Name has been changed ----------------------------------------\n");
            goto CH;

        case '2':
        CID: printf("> > > >Please Input New ID(4 lenth): ");
            scanf("%5d",&newID);
            ClearBar();
            flag = CheckID(newID);
            if (!flag)
            {
                if(newID == 0)
                {
                    printf("\n-------------------------------------- Modify Failed -----------------------------------------------\n");
                    goto CH;
                } 
                printf("\nWarning ---- Vaild Input -------- ID Only Support 4 numbers --------- or Input 0 to exit -----------\n");
                goto CID;
            }
            Sw[a].ID = newID;
            Cgfg = 1;
            printf("\n--------------------------------------- ID has been changed ----------------------------------------\n");
            goto CH;

        case '3':
        CSex:printf("> > > >Please Input Sex(M or F): ");
            scanf(" %1c",&newSex);
            ClearBar();
            flag = (newSex=='M' || newSex=='F')?(1):(0);
            if (!flag)
            {
                if(newSex == '0')
                {
                    printf("\n-------------------------------------- Modify Failed -----------------------------------------------\n");
                    goto CH;
                }
                printf("\nWarning ---- Vaild Input -------- Sex Only Support M(Male) or F(female) --- or Input 0 to exit -----\n");
                goto CSex;
            }
            Sw[a].Sex = newSex;
            Cgfg = 1;
            printf("\n-------------------------------------- Sex has been changed ----------------------------------------\n");
            goto CH;

        case '4':
        CBDay:printf("> > > >Please Input New BirthDay(1990~2010 For:19990526): ");
            scanf("%4d%2d%2d",&year, &month, &day);
            ClearBar();
            flag = CheckBirDay(year, month, day);
            if (!flag)
            {
                if(0 == year == month == day ) //ȫ��Ϊ0��Ϊ���ʽֵΪ1
                {
                    printf("\n-------------------------------------- Modify Failed -----------------------------------------------\n");
                    goto CH;
                }
                printf("\nWarning -- Vaild Input ---- BirthDay Only be Allowed in 1990 to 2010 --- or Input eight 0 to exit --\n");
                goto CBDay;
            }
            Sw[a].Birth.year = year;
            Sw[a].Birth.month = month;
            Sw[a].Birth.day = day;
            Cgfg = 1;
            printf("\n------------------------------------ BirthDay has been changed -------------------------------------\n");
            goto CH;

        case '5':
        Score:printf("> > > >Please Input New Score For 4 Course(1~100 For:98 98 98 98): ");
            scanf("%3d %3d %3d %3d",&c1, &c2, &c3, &c4);
            ClearBar();
            flag = CheckScore(c1, c2, c3, c4);
            if (!flag)
            {
                if(0 == c1 == c2 == c3 == c4)//ȫ��Ϊ0ʱΪ���ʽֵΪ1
                {
                    printf("\n-------------------------------------- Modify Failed -----------------------------------------------\n");
                    goto CH;
                }
                printf("\nWarning ---- Vaild Input -------- Score Only be Allowed in 1 to 100 ---- or Input eight 0 to exit --\n");
                goto Score;
            }
            Sw[a].Core[0]=c1;
            Sw[a].Core[1]=c2;
            Sw[a].Core[2]=c3;
            Sw[a].Core[3]=c4;
            Sw[a].total = Sw[a].Core[0]+Sw[a].Core[1]+Sw[a].Core[2]+Sw[a].Core[3];
            Sw[a].aver = (float)Sw[a].total/4;
            Cgfg = 1;
            printf("\n------------------------------------- Score has been changed --------------------------------------\n");
            goto CH;
        default:
            break;
    }
}

void Deleterecord()
{
    int dID;//Ҫɾ����ID
    int flag;
DID:printf("> > > >Please Input ID to delete(4 lenth, 0 to exit): ");
        scanf("%5d",&dID);
        ClearBar();
        flag = SearchByID(dID);
        if (flag==-1)
        {
            if(dID == 0)
            {
                printf("\n-------------------------------------- Nothing deleted -----------------------------------------------\n");
                return;
            } 
            goto DID;
        }
        else
        {
            printf("\nInformation of ID:%d as follows:",dID);
            Show(flag,flag+1);
            printf("are you sure delete it?(y or n):");
            char c = getchar();
            if (c=='Y' || c=='y')
            {
                Sw[flag] = Sw[Sn-1];
                Sn = Sn - 1;
                Cgfg = 1;
                printf("\n------------------------------------- ID:%d has been Deleted -------------------------------------\n",dID);
            }
            else 
            {
                printf("\n-------------------------------------- Nothing deleted -----------------------------------------------\n");
                return;
            }
        }
}