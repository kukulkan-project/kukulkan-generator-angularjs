(function () {
    'use strict';

    angular
        .module('${project.id}App')
        .directive('modalDraggable', modalDraggable);

    modalDraggable.$inject = ['$document'];

    function modalDraggable($document) {
        var directive = {
            restrict: 'AC',
            link: linkFunc
        };

        return directive;

        function linkFunc(scope, element, attrs) {
            var startX = 0,
                startY = 0,
                x = 0,
                y = 0;

            var dialogWrapper = element.parent();

            dialogWrapper.css({
                position: 'relative'
            });

            dialogWrapper.on('mousedown', function (event) {
                // Prevent default dragging of selected content
                event.preventDefault();
                startX = event.pageX - x;
                startY = event.pageY - y;
                $document.on('mousemove', mousemove);
                $document.on('mouseup', mouseup);
            });

            function mousemove(event) {
                y = event.pageY - startY;
                x = event.pageX - startX;
                dialogWrapper.css({
                    top: y + 'px',
                    left: x + 'px'
                });
            }

            function mouseup() {
                $document.unbind('mousemove', mousemove);
                $document.unbind('mouseup', mouseup);
            }
        }
    }
})();
