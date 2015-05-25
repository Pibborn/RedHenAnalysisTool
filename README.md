# RedHenAnalysisTool
foundation for a hierarchical audio analysis tool for the Red Hen Distributed Lab (https://sites.google.com/site/distributedlittleredhen/)

## Usage
`rhat [[analysis-task]] [[arguments...]]`

###analysis-task
* `segmentation`: broadcast segmentation via audio fingerprinting. uses the `Panako` library by [Joren Six](https://github.com/JorenSix). all arguments will be passed to Panako: [see its documentation](http://panako.be/releases/Panako-latest/readme.html).
* `ambience`: acoustic ambient detection. unsupported at the moment.
