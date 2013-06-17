package {
	import flash.display.*;
	import flash.text.*;
	
	public class helloworld extends MovieClip {
		public function helloworld() {
			var format : TextFormat = new TextFormat();
			format.font = "Arial";
			format.size = 30;
			format.bold = true;
			format.color = 0xFF0000;
			
			var msg : TextField = new TextField();
			msg.x = 100;
			msg.y = 50;
			msg.autoSize = TextFieldAutoSize.LEFT;
			msg.border = true;
			msg.defaultTextFormat = format;
			msg.selectable = false;
			msg.text = "Hello, World!\nProgramming is fun!";
			addChild(msg);
		}
	}
}