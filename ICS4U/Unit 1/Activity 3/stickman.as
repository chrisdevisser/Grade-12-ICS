package {
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	
	public class stickman extends MovieClip {
		public function stickman() {
			addEventListener(MouseEvent.ROLL_OVER, function() {
				scaleX *= 1.5;
				scaleY *= 1.5;
			});
			
			addEventListener(MouseEvent.ROLL_OUT, function() {
				scaleX /= 1.5;
				scaleY /= 1.5;
			});
		}
	}
}