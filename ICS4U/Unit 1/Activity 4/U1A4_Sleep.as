package {
	import flash.display.SimpleButton;
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFormat;
	import flash.text.TextFieldAutoSize;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	public class U1A4_Sleep extends MovieClip {
		public function U1A4_Sleep() {
			//birthDay.tabIndex = 1;
//			birthMonth.tabIndex = 2;
//			birthYear.tabIndex = 3;
//			nowDay.tabIndex = 4;
//			nowMonth.tabIndex = 5;
//			nowYear.tabIndex = 6;
//			
//			calc.addEventListener(MouseEvent.CLICK, calculate);
//			birthDay.addEventListener(KeyboardEvent.KEY_UP, enterPress);
//			birthMonth.addEventListener(KeyboardEvent.KEY_UP, enterPress);
//			birthYear.addEventListener(KeyboardEvent.KEY_UP, enterPress);
//			nowDay.addEventListener(KeyboardEvent.KEY_UP, enterPress);
//			nowMonth.addEventListener(KeyboardEvent.KEY_UP, enterPress);
//			nowYear.addEventListener(KeyboardEvent.KEY_UP, enterPress);

			for (var i : int = -1; (i += 2) < 1000; trace(i));
		}
		
		private function enterPress(e : KeyboardEvent) {
			if (e.charCode == Keyboard.ENTER) {
				calculate(new MouseEvent("CLICK"));
			}
		}
		
		private function calculate(e : MouseEvent) {
			const HOURS_PER_DAY : int = 8;
			const MILLISECONDS_PER_DAY : int = 1000 * 60 * 60 * 24;
			
			var birth : Date = new Date(int(birthYear.text), int(birthMonth.text), int(birthDay.text));
			var today : Date = new Date(int(nowYear.text), int(nowMonth.text), int(nowDay.text));
			
			var days : int = (today.getTime() - birth.getTime()) / MILLISECONDS_PER_DAY;
			
			var format : TextFormat = new TextFormat();
			format.size = 20;
			
			var text : TextField = new TextField();
			text.x = 25;
			text.y = 320;
			text.autoSize = TextFieldAutoSize.LEFT;
			text.defaultTextFormat = format;
			text.text = "You have been alive for " + days + " days.\n";
			text.appendText("You have slept for " + days * HOURS_PER_DAY + " hours.\n");
			
			if (numChildren == 17) {
				removeChildAt(16);
			}
			
			addChild(text);
		}
	}
}