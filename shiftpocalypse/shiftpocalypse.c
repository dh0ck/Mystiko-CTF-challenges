#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
	char y;
	char flag[40] = "Mystiko{f3W_p30pL3_cAn_$h1Ft}"; 
	int new_flag[40] = {1232,1936,1840,1856,1680,1712,1776,1968,1632,816,1392,1520,1792,816,768,1792,1216,816,1520,1584,1040,1760,1520,576,1664,784,1120,1856,2000};

	// The loop in j is to try a different amount of shifts
	for (int j=0; j<10; j++){
	//int j=4;
		for (int i=0; i<29; i++){
			y = flag[i];
			//printf("%d\n",y<<4); // This is used to generate the shifted flag
			char c = new_flag[i] >> j; //4;
			printf("%c", c); // This prints the solution, having "deshifted" the flag by 4 positions
		}
		cout << endl;
	}
	return 0;
}
