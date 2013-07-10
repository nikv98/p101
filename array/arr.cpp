#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>

using namespace std;

int size = 7;
int arr[7];

/*
	Lets return the value at the specified index
*/
int get(int index){
	if(index >= 0 && index < size){
		return arr[index];
	}else{
		return NULL;
	}
}

/*
	Lets set the value of an index with the value we pass in as parameters
*/
bool set(int index, int value){
	if(index >= 0 && index < size){
		arr[index] = value;
		return true;
	}else{
		return false;
	}
}

/*
	Lets print out the contents of our array
*/
void print(){
	for(int index = 0; index < size; index++){
		cout << get(index) << endl;
	}
}

/*
  Lets use our functions
*/
int main(){
	srand(time(NULL));
	for(int n = 0; n < size; n++){
		set(n, rand()%100 + 1); //lets add a random number between 1-100 inclusive
	}
	print();
}