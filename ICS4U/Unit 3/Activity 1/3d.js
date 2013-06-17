http://www.aerotwist.com/tutorials/getting-started-with-three-js/

var WIDTH = 266;
var HEIGHT = 200;
var FRAME = "#frame";

$(function() {
	add3D();
});

// Rotate an object around an arbitrary axis in object space
var rotObjectMatrix;
function rotateAroundObjectAxis(object, axis, radians) {
    rotObjectMatrix = new THREE.Matrix4();
    rotObjectMatrix.makeRotationAxis(axis.normalize(), radians);
    object.matrix.multiply(rotObjectMatrix);      // post-multiply
    object.rotation.setEulerFromRotationMatrix(object.matrix);
}

THREE.Object3D._matrixAux = new THREE.Matrix4(); // global auxiliar variable
// Warnings: 1) axis is assumed to be normalized. 
//  2) matrix must be updated. If not, call object.updateMatrix() first  
//  3) this assumes we are not using quaternions
THREE.Object3D.prototype.rotateAroundWorldAxis = function(axis, radians) { 
    THREE.Object3D._matrixAux.makeRotationAxis(axis, radians);
    this.matrix.multiplyMatrices(THREE.Object3D._matrixAux,this.matrix); // r56
    THREE.Object3D._matrixAux.extractRotation(this.matrix);
    this.rotation.setEulerFromRotationMatrix(THREE.Object3D._matrixAux, this.eulerOrder ); 
    this.position.getPositionFromMatrix( this.matrix );
}
THREE.Object3D.prototype.rotateAroundWorldAxisX = function(radians) { 
    this.rotateAroundWorldAxis(new THREE.Vector3(1, 0, 0), radians);
}
THREE.Object3D.prototype.rotateAroundWorldAxisY = function(radians) { 
    this.rotateAroundWorldAxis(new THREE.Vector3(0, 1, 0), radians);
}
THREE.Object3D.prototype. rotateAroundWorldAxisZ = function(radians){ 
    this.rotateAroundWorldAxis(new THREE.Vector3(0, 0, 1), radians);
}

function getPageCoords(object) {
	var widthHalf = WIDTH / 2, heightHalf = HEIGHT / 2;

	var projector = new THREE.Projector();
	var vector = new THREE.Vector3();
	vector.getPositionFromMatrix(object.matrixWorld);
	vector = projector.projectVector(vector, camera);

	var ret = new THREE.Vector3();
	ret.x = (vector.x * widthHalf) + widthHalf + $(FRAME).offset().left;
	ret.y = -(vector.y * heightHalf) + heightHalf + $(FRAME).offset().top;
	return ret;
}

function getCentreCoords() {
	var widthHalf = WIDTH / 2, heightHalf = HEIGHT / 2;	
	var widthHalf = WIDTH / 2, heightHalf = HEIGHT / 2;	
	var ret = new THREE.Vector3();
	ret.x = widthHalf + $(FRAME).offset().left;
	ret.y = heightHalf + $(FRAME).offset().top;
	return ret;
}

var renderer;
var camera;
var scene;

var leftEye;
var rightEye;
var leftMouth;
var rightMouth;

function updateRotation() {
	var x = 0.007;
	var y = 0.005;
	var z = -0.005;
	leftEye.rotateAroundWorldAxisX(x);
	rightEye.rotateAroundWorldAxisX(x);
	leftMouth.rotateAroundWorldAxisX(x);
	rightMouth.rotateAroundWorldAxisX(x);
	
	leftEye.rotateAroundWorldAxisY(y);
	rightEye.rotateAroundWorldAxisY(y);
	leftMouth.rotateAroundWorldAxisY(y);
	rightMouth.rotateAroundWorldAxisY(y);
	
	leftEye.rotateAroundWorldAxisZ(z);
	rightEye.rotateAroundWorldAxisZ(z);
	leftMouth.rotateAroundWorldAxisZ(z);
	rightMouth.rotateAroundWorldAxisZ(z);
}

function add3D() {	
	renderer = new THREE.WebGLRenderer();
	camera = new THREE.PerspectiveCamera(45, WIDTH/HEIGHT, 0.1, 10000);
	scene = new THREE.Scene();

	scene.add(camera);
	camera.position.z = 22;
	renderer.setSize(WIDTH, HEIGHT);
	
	$(FRAME).append(renderer.domElement);
	
	var eyeMat = new THREE.MeshLambertMaterial({color: 0x0000FF});
	var mat = new THREE.MeshLambertMaterial({color: 0xCC0000});
	
	leftEye = new THREE.Mesh(new THREE.SphereGeometry(2, 10, 10), eyeMat);
	leftEye.position.x = -3;
	leftEye.position.y = 5;
	scene.add(leftEye);
	
	rightEye = new THREE.Mesh(new THREE.SphereGeometry(2, 10, 10), eyeMat);
	rightEye.position.x = 3;
	rightEye.position.y = 5;
	scene.add(rightEye);
	
	leftMouth = new THREE.Mesh(new THREE.CubeGeometry(6, 2, 2, 10, 10, 10), mat);
	leftMouth.position.x = -2.1;
	leftMouth.position.y = -3;
	rotateAroundObjectAxis(leftMouth, new THREE.Vector3(1, 0, 0), Math.PI / 6);
	rotateAroundObjectAxis(leftMouth, new THREE.Vector3(0, 0, 1), -Math.PI / 6);
	scene.add(leftMouth);
	
	rightMouth = new THREE.Mesh(new THREE.CubeGeometry(6, 2, 2, 10, 10, 10), mat);
	rightMouth.position.x = 2.1;
	rightMouth.position.y = -3;
	rotateAroundObjectAxis(rightMouth, new THREE.Vector3(1, 0, 0), Math.PI / 6);
	rotateAroundObjectAxis(rightMouth, new THREE.Vector3(0, 0, 1), Math.PI / 6);
	scene.add(rightMouth);
	
	var light = new THREE.PointLight(0xFFFFFF);
	light.position.x = -10;
	light.position.y = 10;
	light.position.z = 30;
	
	scene.updateMatrixWorld();
	
	scene.add(light);
	render();
}

function render() {
	requestAnimationFrame(render);
	updateRotation();
	renderer.render(scene, camera);
}