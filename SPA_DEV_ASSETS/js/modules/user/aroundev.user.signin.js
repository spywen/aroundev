/**
 * Created by laurent on 06/11/14.
 */
angular.module('aroundev.user.signin',[
    'ui.router'
])
.config(function($stateProvider){
    $stateProvider.state('signin', {
        url: '/signin',
        templateUrl: '/app/js/modules/user/view/signin.html',
        controller: 'signinCtrl',
        authenticate: false,
        hasRoles:[],
        hasNotRoles:[]
    });
})
.controller('signinCtrl',function($scope){

    $scope.newUser = {};

    $scope.signIn = function(user) {
        $scope.newUser = angular.copy(user);
    };

}).directive('passwordConfirmationValidation', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$validators.integer = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    return false;
                }else if(modelValue == scope.newUser.password){
                    return true;
                }
                return false;
            };
        }
    };
});