// JavaScript source code (array.js)
function array() {
    var result = [];
    if (arguments.length == 0) {
        // 리턴할 배열(result) 완성시키기
    } else if (arguments.length == 1) {
        // 리턴할 배열(result) 완성시키기
        // arguments[0]만큼 빈 배열방 추가
        for (var cnt = 1; cnt <= arguments[0]; cnt++)
            result.push('');
    } else if (arguments.length > 1) {
        // 리턴할 배열(result) 완성시키기
        for (var idx = 0; idx < arguments.length; idx++) {
            result.push(arguments[idx]);
        }
    }
    return result;
}