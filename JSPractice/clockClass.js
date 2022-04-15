class Clock {
    constructor(time = {}) {
        this.hours = this.checkTime(time.hours, true) ? time.hours : 0;
        this.minutes = this.checkTime(time.minutes, false) ? time.minutes : 0;
        this.seconds = this.checkTime(time.seconds, false) ? time.seconds : 0;

    }

    currentTime() {


        let hours = this.hours.toString();
        if (hours.length === 1) {
            hours = "0" + hours;
        }


        let minutes = this.minutes.toString().padLeft(2, "0");
        let seconds = this.seconds.toString().padLeft(2, "0");

        return `${hours}:${minutes}:${seconds}`
    }


    get hours() {
        return this._hours;
    }

    set hours(hours) {
        if (this.checkTime(hours, true)) {
            this._hours = hours;
        }
    }

    get minutes() {
        return this._minutes;
    }

    get seconds() {
        return this._seconds;
    }

    set minutes(minutes) {
        if (this.checkTime(minutes, false)) {
            this._minutes = minutes;
        }
    }

    set seconds(seconds) {
        if (this.checkTime(seconds, false)) {
            this._seconds = seconds;
        }
    }

    checkTime(time, isHours) {
        if (isHours) {
            return time >= 0 && time < 24;
        } else {
            return time >= 0 && time < 60;
        }
    }


    tick() {
        if (this.seconds < 59) {
            this.seconds++;
        } else if (this.minutes < 59) {
            this.seconds = 0;
            this.minutes++;
        } else if (this.hours < 23) {
            this.seconds = 0;
            this.minutes = 0;
            this.hours++;
        } else {
            this.seconds = 0;
            this.minutes = 0;
            this.hours = 0;
        }

        return this;
    }
}

class DigitalClock extends Clock {
    constructor(time = {}) {
        super(time);
        this.format = '24-hour format';
        this.alarms = [];
    }

    toggleFormat() {
        if (this.format === '24-hour format') {
            this.format = '12-hour format';
        } else {
            this.format = '24-hour format';
        }
    }

    currentTime() {
        if (this.format === '24-hour format') {
            return super.currentTime();
        } else {
            let seconds = this.seconds.toString().padLeft(2, "0");
            let minutes = this.minutes.toString().padLeft(2, "0");
            let hours;
            let am = "AM";

            if (this.hours > 12) {
                hours = (this.hours - 12).toString().padLeft(2, "0");
                am = "PM";
            } else {
                hours = this.hours.toString().padLeft(2, "0");
            }
            return `${hours}:${minutes}:${seconds} ${am}`;
        }
    }

    setAlarm(time) {
        const timeString = new DigitalClock(time).currentTime();

        this.alarms.push(timeString);

    }

    tick() {
        super.tick();

        for (let i = 0; i < this.alarms.length; i++) {
            let currentTime = this.alarms[i];

            if (currentTime === this.currentTime()) {
                console.log("ALARM");
            }
        }
        return this;
    }
}