package {
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFormat;
	import flash.text.TextFieldAutoSize;

	public class U1A3_Greetings extends MovieClip {
		public function U1A3_Greetings() {
			initText();
			
			basch_.height = (stage.stageHeight - text_.height) / 2;
			basch_.width = basch_.height * 576/917;

			randomizePosition(); 
			addChild(basch_);
			addChild(text_);
			
			basch_.addEventListener(MouseEvent.ROLL_OVER, function() {
				if (text_.y > basch_.y) {
					text_.y += basch_.height / 2;
				}
				
				basch_.scaleX *= 1.5;
				basch_.scaleY *= 1.5;
				
				if (basch_.y + basch_.height > stage.stageHeight) {
					basch_.y = stage.stageHeight - basch_.height;
					text_.y = basch_.y - text_.height;
				}
			});
			
			basch_.addEventListener(MouseEvent.ROLL_OUT, function() {
				basch_.scaleX /= 1.5;
				basch_.scaleY /= 1.5;
				
				if (text_.y > basch_.y) {
					text_.y -= basch_.height / 2;
				}
			});
			
			basch_.addEventListener(MouseEvent.CLICK, function() {
				++clicks_;
				
				if (clicks_ >= 10) {
					text_.text = "You suck.";
				} else if (clicks_ >= 5) {
					text_.text = "Cut it out.";
				} else if (clicks_ >= 4) {
					text_.text = "Quit it.";
				} else if (clicks_ >= 3) {
					text_.text = "Stop it.";
				} else if (clicks_ >= 2) {
					text_.text = "Ow.";
				} else {
					text_.text = "Perhaps you did.";
				}
				
				randomizePosition();
			});
		}
		
		private var basch_ : U1A3_GreetingsMethods = new U1A3_GreetingsMethods();
		private var text_ : TextField = new TextField();
		private var clicks_ : int = 0;
		
		private function initText() {
			//blue, Comic Sans MS, 18-point font
			var format : TextFormat = new TextFormat();
			format.color = 0x0000FF;
			format.font = "Comic Sans MS";
			format.size = 18;
			
			//non-selectable text field
			text_.autoSize = TextFieldAutoSize.CENTER;
			text_.defaultTextFormat = format;
			text_.selectable = false;
			text_.text = "Expected something\ndifferent?";
		}
		
		private function randomizePosition() {
			//x->random in range [0, stage width - image width or text width), whichever is bigger
			//y->random in range [0, stage height - image height)
			basch_.x = Math.random() * (stage.stageWidth - Math.max(basch_.width, text_.width));
			basch_.y = Math.random() * (stage.stageHeight - basch_.height);
			
			//x->centered around image's center
			//y->just above image, or just below if image is too high
			text_.x = basch_.x;
			text_.y = basch_.y < text_.height ? basch_.y + basch_.height : basch_.y - text_.height;
		}
	}
}