describe('Testing services suite', function(){

    describe('Auth Service specs', function(){
        var _authService_;

        beforeEach(function(){
            module('aroundev.service.utils');
            inject(function(utilsService){
                _authService_ = utilsService;
            });
        });

        it('parameter should be an array', function (){
            var baseList = 'USER';
            var searchedObjects = ['USER'];
            expect(_authService_.containMoreThanOne(baseList, searchedObjects)).toEqual(_authService_.errorMessage.containMoreThanOne_Parameters);
        });

        it('should found one', function (){
            var baseList = ['ADMIN', 'USER'];
            var searchedObjects = ['USER'];
            expect(_authService_.containMoreThanOne(baseList, searchedObjects)).toBeTruthy();
        });

        it('should not found one', function (){
            var baseList = ['ADMIN'];
            var searchedObjects = ['USER'];
            expect(_authService_.containMoreThanOne(baseList, searchedObjects)).toBeFalsy();
        });

    });

});