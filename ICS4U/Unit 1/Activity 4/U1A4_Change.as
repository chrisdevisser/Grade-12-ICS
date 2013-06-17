/* 	Programmer Name: 
	Date:
	File Name:  U1A4_Change.as
	Program Description:  Include a brief description of the program
*/
   
//  Use these symsbols to add line comments to identify and explain where you made modifications to the code.
   
   
package {
	import flash.display.*;
	import flash.ui.Keyboard;
	import flash.text.*;
	import flash.events.MouseEvent;
	import flash.events.KeyboardEvent;

	public class U1A4_Change extends MovieClip {
		public function U1A4_Change():void {
			//call findChange when button pressed
			submit_btn.addEventListener(MouseEvent.CLICK, findChange);
			
			//pretend button is clicked when enter is hit in input box
			currencyIn.addEventListener(KeyboardEvent.KEY_UP, function(e : KeyboardEvent) {if (e.keyCode == Keyboard.ENTER) findChange(new MouseEvent("CLICK"));});
		}
		
		private function findChange(event : MouseEvent):void {
			//create variable for text format
			var myFormat:TextFormat=new TextFormat;
			myFormat.font="Arial";
			myFormat.size=20;
			myFormat.bold=true;
			myFormat.color=0x660000;
			
			//create variable for output message
			var myMessage:TextField=new TextField; 
			myMessage.x=86;
			myMessage.y=190;
			myMessage.autoSize=TextFieldAutoSize.LEFT;
			myMessage.border=true;
			myMessage.defaultTextFormat=myFormat;
			
			var toonies : int = 0;
			var loonies : int = 0;
			var quarters:int=0;
			var dimes:int=0;
			var nickels:int=0;
			var pennies:int=0;
			var leftOver:int=0;

			var amountIn :Number;
			var cents:int;

			//convert text in input box to floating-point number
			//and multiply by 100 to get cents
			amountIn=Number(currencyIn.text);
			cents = int(amountIn * 100);

			//even number of times 200 cents divides in is toonies
			//remainder is how much is left for smaller coins
			toonies = cents / 200;
			leftOver = cents % 200;
			
			loonies = leftOver / 100;
			leftOver = cents % 100;

			quarters = leftOver / 25;
			leftOver= cents % 25;

			dimes = leftOver  / 10;
			leftOver = leftOver % 10;

			nickels = leftOver / 5;
			leftOver = leftOver % 5;

			pennies = leftOver;

			//form output string
			myMessage.text = "Amount = $" + amountIn 
						   + "\n\ntoonies: " + toonies 
						   + "\nloonies: " + loonies 
						   + "\nquarters: " + quarters 
						   + "\ndimes: " + dimes 
						   + "\nnickels: " + nickels 
						   + "\npennies: " + pennies;
			
			//display output
			addChild(myMessage);
		}
	}
}