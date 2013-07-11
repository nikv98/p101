
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>

using namespace std;


//global variables
//how many kinds of drinks?
string drinks [] = {
					"1. Coke",
					"2. Mello Yello",
					"3. Dr Pepper",
					"4. Sunkist",
					"5. Sprite"
					};
//lets build our inventory of drinks
int inventory [] = {
					5,
					0,
					7,
					8,
					0
					};

int numDrinks = 5;

void listProducts(){
	for(int n = 0; n < numDrinks; n++){
		cout << drinks[n] << endl;
	}
}

bool selectProduct(int product){
	if(product <= 0 || product > numDrinks){
		return false;
	}else{
		return true;
	}
}

bool vend(int product){
	if(inventory[product] > 0){
		inventory[product]--;
		return true;
	}else{
		return false;
	}
}

int main(){
	cout << "Welcome to the We Like Your Money vending machine. Always ready to take your money for a cool drink" << endl;
	listProducts();
	//lets get the customer's selection
	int choice;
	do{
      cout<<"enter your selection 1-5"<<endl;
      cin>>choice;
      if (cin.fail()) {
         cout<<"error: that's not a number!! try again"<<endl;
         cin.clear(); // clear the stream
         cin.ignore(std::numeric_limits<int>::max(),'\n');
         cout<<"enter your selection #1-5"<<endl; //ask again
         cin>>choice;
         //we know choice is a valid int
      }
 	} while (cin.fail() || !selectProduct(choice));

 	//we know our input is 1-5
 	if(vend(choice)){
 		cout << "Hre's your " << drinks[choice] << endl;
 	}else{
 		cout << "we're all out of " << drinks[choice] << endl;
 	}
	//cout << "Please pay $1" << endl;


}