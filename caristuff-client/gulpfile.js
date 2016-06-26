import gulp from "gulp";
import babel from "gulp-babel";

gulp.task("js", function () {
    return gulp.src("src/js/*.js")
        .pipe(babel())
        .pipe(gulp.dest("dist"));
});

gulp.task("html", ["js"], () =>
    gulp.src("./src/html/*.html")
        .pipe(gulp.dest("./dist"))
);

gulp.task('watch', () => {

    gulp.watch("src/js/*.js", ['js']);
    gulp.watch("src/html/*.html", ['html'])

});

gulp.task("build", ["html"]);
gulp.task("buildSkipTests", ["html"]);

gulp.task("default", ["clean"], () => sequence("build"));