(function () {
    'use strict';

    angular
        .module('${project.id}App')
        .directive('modalDialog', function () {
            return {
                restrict: 'AC',
                link: function ($scope, element) {
                    var draggableStr = "draggableModal";
                    var header = angular.element('.modal-header', element);

                    header.on('mousedown', (mouseDownEvent) => {
                        var modalDialog = element;
                        var offset = header.offset();

                        modalDialog.addClass(draggableStr).parents().on('mousemove', (mouseMoveEvent) => {
                            angular.element("." + draggableStr, modalDialog.parents())
                                .offset({
                                    top: mouseMoveEvent.pageY - (mouseDownEvent.pageY - offset.top),
                                    left: mouseMoveEvent.pageX - (mouseDownEvent.pageX - offset.left)
                                });
                        }).on('mouseup', () => {
                            modalDialog.removeClass(draggableStr);
                        });
                    });
                }
            }
        });
})();
