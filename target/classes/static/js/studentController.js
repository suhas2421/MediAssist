var mainApp = angular.module("mainApp", []);

mainApp.controller('studentController', function($scope){
	$scope.student = {
			firstName: "Suhas",
			lastName: "Jadhav",
			
			fullName: function(){
				var studentObject;
				studentObject = $scope.student;
				return studentObject.firstName +" "+ studentObject.lastName;
			}
	};
});