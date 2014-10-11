/**
 * Created by laurent on 11/10/2014.
 */
var aroundevApp = angular.module('aroundevApp',['pascalprecht.translate', 'ngCookies']).config(function($translateProvider){
    $translateProvider.useStaticFilesLoader({
        prefix: '/app/languages/',
        suffix: '.json'
    });
    $translateProvider.useCookieStorage();
    $translateProvider.preferredLanguage('en');
});
aroundevApp.controller('translateCtrl', function($scope, $translate, $cookies) {
    $scope.en = false;
    $scope.fr = false;
    var currentLanguage = $cookies.NG_TRANSLATE_LANG_KEY;
    if(currentLanguage === '"en"'){
        $scope.en = true;
    }else if(currentLanguage === '"fr"'){
        $scope.fr = true;
    }else{
        $scope.en = true;
    }
    $scope.changeLanguage = function (langKey){
        $translate.use(langKey);
        $scope.en = false;
        $scope.fr = false;
        if(langKey === 'en'){
            $scope.en = true;
        }else if(langKey === 'fr'){
            $scope.fr = true;
        }else{
            $scope.en = true;
        }
    };
});
