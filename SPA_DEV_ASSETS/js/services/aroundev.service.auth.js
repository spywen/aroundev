/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.service.auth', [
    'pascalprecht.translate',
    'restangular',
    'aroundev.service.utils'
])
.config(function(RestangularProvider){
    //RestangularProvider.setBaseUrl('/api/user/');
})
.service('authService',function($translate, $http, $location, Restangular, $q, toastr, utilsService){

    this.login = function(login,password){
        return $q(function(resolve, reject){
            Restangular.one('login').customPOST("login="+login+"&password="+password, undefined, undefined, {'Content-Type': 'application/x-www-form-urlencoded'}).then(function(){
                resolve(true);
            },function(){
                reject(false);
            });
        });
    };

    this.logout = function(){
        return $q(function(resolve, reject){
            Restangular.one('logout').get().then(function(){
                window.location.reload();
                resolve(result);
            }, function(){
                toastr.error($translate.instant('LOGIN_LOG_OUT_FAILED'));
                reject(false);
            });
        });
    };

    this.getProfile = function(){
        return $q(function(resolve, reject){
            if(_.isEmpty(window.user.roles)){
                Restangular.one('api/user/currentProfil').get().then(function(result){
                    if(!_.isUndefined(result.type) && result.type == 'NotConnected'){
                        reject(result);
                    }else{
                        var rolesNames = [];
                        _.forEach(result.roles, function(role){
                            rolesNames.push(role.name);
                        });
                        window.user = {username: result.login, roles:rolesNames};
                        resolve(window.user);
                    }
                },function(){
                    reject(false);
                });
            }else{
                resolve(window.user);
            }
        });
    };

    this.hasRoles = function(roles){
        return $q(function(resolve, reject){
            if(!_.isEmpty(window.user.roles)){
                resolve(utilsService.containMoreThanOne(user.roles, roles));
            }else{
                resolve(false);
            }
        });
    };

    this.getUser = function(){
        if(!_.isEmpty(window.user.roles)){
            return window.user;
        }else{
            return false;
        }

    };

});