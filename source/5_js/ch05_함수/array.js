// JavaScript source code (array.js)
function array() {
    var result = [];
    if (arguments.length == 0) {
        // ������ �迭(result) �ϼ���Ű��
    } else if (arguments.length == 1) {
        // ������ �迭(result) �ϼ���Ű��
        // arguments[0]��ŭ �� �迭�� �߰�
        for (var cnt = 1; cnt <= arguments[0]; cnt++)
            result.push('');
    } else if (arguments.length > 1) {
        // ������ �迭(result) �ϼ���Ű��
        for (var idx = 0; idx < arguments.length; idx++) {
            result.push(arguments[idx]);
        }
    }
    return result;
}