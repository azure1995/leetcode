/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function (version1, version2) {
    let array_version1 = version1.split('.');
    let array_version2 = version2.split('.');
    let len1 = array_version1.length;
    let len2 = array_version2.length;
    let len = Math.max(len1, len2);
    array_version2.length = array_version1.length = len;
    array_version1.fill(0, len1, len);
    array_version2.fill(0, len2, len);
    for (let i = 0; i < len; i++) {
        if (Number.parseInt(array_version1[i]) > Number.parseInt(array_version2[i])) {
            return 1;
        } else if (Number.parseInt(array_version1[i]) < Number.parseInt(array_version2[i])) {
            return -1;
        }
    }
    return 0;
};