mainApp.controller('studentDetailsController', function($scope) {
	$scope.student = {
		firstName : "Suhas",
		lastName : "Jadhav",
		fees : 500,

		subjects : [ {
			name : "A",
			marks : 20
		}, {
			name : "B",
			marks : 10
		}, {
			name : "C",
			marks : 30
		}, {
			name : "D",
			marks : 40
		} ],
		
		fullName: function() {
            var studentObject;
            studentObject = $scope.student;
            return studentObject.firstName + " " + studentObject.lastName;
         }

	};

});