// interval.js
// now.getInterval(before)
// now:this / before:otherday
Date.prototype.getInterval = 
function (otherday) {
    var diff;
    if (this > otherday) {
        diff = this.getTime() - otherday.getTime();
    } else {
        diff = otherday.getTime() - this.getTime();
    }
    return Math.floor(diff / (1000 * 60 * 60 * 24));
}
