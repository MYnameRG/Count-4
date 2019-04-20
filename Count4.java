package Count4;
import java.util.Scanner;

public class Count4
{
static int x_length;
static int y_length;

public Count4()
{
x_length=33;
y_length=29;
}

static void Boundry(char blocks[][])
{
for(int i=0;i<x_length;i++)
{
for(int j=0;j<y_length;j++)
{
blocks[i][j]=' ';
}
}
}

static void YBorder(char blocks[][])
{
for(int i=0;i<x_length;i++)
{
for(int j=0;j<y_length;j++)
{
if(j%4==0)
blocks[i][j]='|';
}
}
}

static void XBorder(char blocks[][])
{
for(int i=0;i<x_length;i++)
{
for(int j=0;j<y_length;j++)
{
if(i%4==0)
blocks[i][j]='-';
}
}
}

static void CheckRowElements(char ln,char blocks[][],char value)
{
for(int j=2;j<=26;j=j+4)
{
if(blocks[2][j]==ln)
{
for(int i=30;i>=6;i=i-4)
{
if(blocks[i][j]==' ')
{
blocks[i][j]=value;
break;
}
}
}
}
} 

static void Player1(char blocks[][])
{
char ln,value;
Scanner s = new Scanner(System.in);
System.out.println("Player 1 turns..");
System.out.print("Select Lines Which You Want (Put A-G): ");
ln=s.next().charAt(0);
CheckRowElements(ln,blocks,'X');
}

static void Player2(char blocks[][])
{
char value,ln;
Scanner s = new Scanner(System.in);
System.out.println("Player 2 turns..");
System.out.print("Select Lines Which You Want (Put A-G): ");
ln=s.next().charAt(0);
CheckRowElements(ln,blocks,'O');
}

static int XCheckColumn(char blocks[][])
{
int count=0;
for(int i=2;i<=26;i=i+4)
{
count=0;
for(int j=6;j<=18;j=j+4)
{
count=0;
for(int k=j;k<=j+12;k=k+4)
{
if(blocks[k][i]=='X') count++;
}
if(count==4) return 1;
}
}
return 0;
}

static int OCheckColumn(char blocks[][])
{
int count=0;
for(int i=2;i<=26;i=i+4)
{
count=0;
for(int j=6;j<=18;j=j+4)
{
count=0;
for(int k=j;k<=j+12;k=k+4)
{
if(blocks[k][i]=='O') count++;
}
if(count==4) return 1;
}
}
return 0;
}

static int XCheckRow(char blocks[][])
{
int count=0;
for(int i=6;i<=30;i=i+4)
{
count=0;
for(int j=2;j<=14;j=j+4)
{
count=0;
for(int k=j;k<=j+12;k=k+4)
{
if(blocks[i][k]=='X') count++;
}
if(count==4) return 1;
}
}
return 0;
}

static int OCheckRow(char blocks[][])
{
int count=0;
for(int i=6;i<=30;i=i+4)
{
count=0;
for(int j=2;j<=14;j=j+4)
{
count=0;
for(int k=j;k<=j+12;k=k+4)
{
if(blocks[i][k]=='O') count++;
}
if(count==4) return 1;
}
}
return 0;
}

/*static int XCheckDiagonal(char blocks[][])
{
/*int count=0;
for(int i=6,j=2;i<=30,j<=26;i=i+4,j=j+4)
{
count=0;
for(int m=2;m<=14;m=m+4)
{
count=0;
for(int k=j;k<=j+12;k=k+4)
{
if(blocks[i][k]=='O') count++;
}
if(count==4) return 1;
}
}
return 0;*/
/*for(int i=1;i<10;i=i+4)
{
if(blocks[i][i]=='X')
count++;
}
if(count==3) return 1;

count=0;
for(int i=1;i<10;i=i+4)
{
if(blocks[i][j]=='X')
{
j=j-4;
count++;
}
}
if(count==3) return 1;

return 0;*/

static int OCheckDiagonal(char blocks[][])
{
int count=0,j=9;
for(int i=1;i<10;i=i+4)
{
if(blocks[i][i]=='O')
count++;
}
if(count==3) return 1;

count=0;
for(int i=1;i<10;i=i+4)
{
if(blocks[i][j]=='O')
{
j=j-4;
count++;
}
}
if(count==3) return 1;

return 0;
}

static void Display(char blocks[][])
{
for(int i=0;i<x_length;i++)
{
for(int j=0;j<y_length;j++)
{
System.out.print(blocks[i][j]);
}
System.out.println();
}
}

static void AddRowNumber(char blocks[][])
{
int k=65;
for(int j=2;j<=26;j=j+4)
{
blocks[2][j]=(char)k;
k++;
}
}

public static void Main()
{
int turn=49,count=0,count1=0;
Count4 c4 = new Count4();
char blocks[][] = new char[x_length][y_length];
c4.Boundry(blocks);
c4.YBorder(blocks);
c4.XBorder(blocks);
c4.AddRowNumber(blocks);
System.out.print("\033\143");
while(turn--!=0)
{
c4.Display(blocks);
c4.Player1(blocks);
if(c4.XCheckRow(blocks)==1 || c4.XCheckColumn(blocks)==1)
{
System.out.print("\033\143");
c4.Display(blocks);
System.out.println("Player 1 Win...");
break;
}
System.out.print("\033\143");
c4.Display(blocks);
c4.Player2(blocks);
if(c4.OCheckRow(blocks)==1 || c4.OCheckColumn(blocks)==1)
{
System.out.print("\033\143");
c4.Display(blocks);
System.out.println("Player 2 Win...");
break;
}
System.out.print("\033\143");
}
}
}
