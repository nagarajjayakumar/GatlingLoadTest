var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "8",
        "ok": "0",
        "ko": "8"
    },
    "minResponseTime": {
        "total": "10",
        "ok": "-",
        "ko": "10"
    },
    "maxResponseTime": {
        "total": "18",
        "ok": "-",
        "ko": "18"
    },
    "meanResponseTime": {
        "total": "13",
        "ok": "-",
        "ko": "13"
    },
    "standardDeviation": {
        "total": "3",
        "ok": "-",
        "ko": "3"
    },
    "percentiles1": {
        "total": "13",
        "ok": "-",
        "ko": "13"
    },
    "percentiles2": {
        "total": "14",
        "ok": "-",
        "ko": "14"
    },
    "percentiles3": {
        "total": "17",
        "ok": "-",
        "ko": "17"
    },
    "percentiles4": {
        "total": "18",
        "ok": "-",
        "ko": "18"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 8,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "8",
        "ok": "-",
        "ko": "8"
    }
},
contents: {
"req_interactive-spa-c2fc7": {
        type: "REQUEST",
        name: "Interactive Spark Command Simulation",
path: "Interactive Spark Command Simulation",
pathFormatted: "req_interactive-spa-c2fc7",
stats: {
    "name": "Interactive Spark Command Simulation",
    "numberOfRequests": {
        "total": "8",
        "ok": "0",
        "ko": "8"
    },
    "minResponseTime": {
        "total": "10",
        "ok": "-",
        "ko": "10"
    },
    "maxResponseTime": {
        "total": "18",
        "ok": "-",
        "ko": "18"
    },
    "meanResponseTime": {
        "total": "13",
        "ok": "-",
        "ko": "13"
    },
    "standardDeviation": {
        "total": "3",
        "ok": "-",
        "ko": "3"
    },
    "percentiles1": {
        "total": "13",
        "ok": "-",
        "ko": "13"
    },
    "percentiles2": {
        "total": "14",
        "ok": "-",
        "ko": "14"
    },
    "percentiles3": {
        "total": "17",
        "ok": "-",
        "ko": "17"
    },
    "percentiles4": {
        "total": "18",
        "ok": "-",
        "ko": "18"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 8,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "8",
        "ok": "-",
        "ko": "8"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
