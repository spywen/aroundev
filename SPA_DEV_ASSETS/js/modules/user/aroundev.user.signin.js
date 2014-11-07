/**
 * Created by laurent on 06/11/14.
 */
angular.module('aroundev.user.signin',[
    'aroundev.service.auth',
    'pascalprecht.translate',
    'toastr',
    'ui.router'
])
.config(function($stateProvider){
    $stateProvider.state('signin', {
        url: '/signin',
        templateUrl: '/app/js/modules/user/view/signin.html',
        controller: 'signinCtrl',
        authenticate: false,
        hasRoles:[],
        hasNotRoles:["AUTHENTICATED"]
    });
})
.controller('signinCtrl',function($scope, authService, toastr, $translate, $state){

    $scope.signIn = function(user) {
        var newUser = angular.copy(user);
        authService.signIn(newUser).then(function(result){
            toastr.success($translate.instant('SIGNIN_SUCCESS_REGISTRATION'));
            $state.transitionTo("login");
        },function(error){
            toastr.error($translate.instant('SIGNIN_ERROR_REGISTRATION'));
            $state.transitionTo("index");
        });
    };

}).directive('passwordConfirmationValidation', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$validators.passwordValidation = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    return false;
                }else if(modelValue == scope.newUser.password){
                    return true;
                }
                return false;
            };
        }
    };
}).directive('loginValidation', function(authService, toastr, $translate, $q) {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$asyncValidators.loginValidation = function(modelValue, viewValue) {
                var value = modelValue || viewValue;

                return authService.loginExist(value).then(function(result){
                    if (result) {
                        toastr.error($translate.instant('SIGNIN_ERROR_LOGIN_EXIST'));
                        return $q.reject('already exists');
                    }
                    return true;
                },function(){
                    toastr.error($translate.instant('COMMON_ERROR'));
                    $q.reject('error');
                });
            };
        }
    };
}).directive('supinfoIdValidation', function(authService, toastr, $translate, $q) {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$asyncValidators.supinfoIdValidation = function(modelValue, viewValue) {
                var value = modelValue || viewValue;

                return authService.supinfoIdExist(value).then(function(result){
                    if (result) {
                        toastr.error($translate.instant('SIGNIN_ERROR_SUPINFO_ID_EXIST'));
                        return $q.reject('already exists');
                    }
                    return true;
                },function(){
                    toastr.error($translate.instant('COMMON_ERROR'));
                    $q.reject('error');
                });
            };
        }
    };
}).directive('emailValidation', function(authService, toastr, $translate, $q) {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$asyncValidators.emailValidation = function(modelValue, viewValue) {
                var value = modelValue || viewValue;

                return authService.emailExist(value).then(function(result){
                    if (result) {
                        toastr.error($translate.instant('SIGNIN_ERROR_EMAIL_EXIST'));
                        return $q.reject('already exists');
                    }
                    return true;
                },function(){
                    toastr.error($translate.instant('COMMON_ERROR'));
                    $q.reject('error');
                });
            };
        }
    };
});