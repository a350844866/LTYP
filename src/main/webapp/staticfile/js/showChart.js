//载入图表
$(function () {

    var chartOutChar = null;

    var option1 = {
        title: {
            text: '2017年全球影视分类数据分析',
            subtext: '数据来源:爬取时光网',

            x: 'center'
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {

            x: 'center',
            y: 'bottom',
            data: ['剧情', '战争', '恐怖', '动画', '科幻', '动作', '犯罪', '励志', '喜剧']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        series: [

            {
                name: '面积模式',
                type: 'pie',
                radius: [30, 110],
                center: ['50%', '50%'],
                roseType: 'area',
                data: [
                    {value: 10, name: '剧情'},
                    {value: 40, name: '战争'},
                    {value: 15, name: '恐怖'},
                    {value: 25, name: '动画'},
                    {value: 20, name: '科幻'},
                    {value: 35, name: '动作'},
                    {value: 30, name: '犯罪'},
                    {value: 37, name: '励志'},
                    {value: 28, name: '喜剧'}
                ]
            }
        ]


    };
    chartOutChar = echarts.init(document.getElementById('showChart'));
    chartOutChar.setOption(option1);

});