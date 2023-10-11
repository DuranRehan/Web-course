var allCourses = new Vue({
    el: '#allCourses',
    data: {
        courses: []
    },
    methods: {
        getAllCourses: function () {
            axios.get('/api/courses/all')
                .then(function (response) {
                    allCourses.courses = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        detailsCourse: function (id) {
            axios.get('/api/courses?id=' + id)
                .then(function (response) {
                    data = response.data;
                    $('#details-courses').empty();
                    $('#details-courses').append(`
                        <li>
                            <h3>Sigle : ${data.id}</h3>
                        </li>
                        <li>
                            <h3>Intitulé : ${data.title}</h3>
                        </li>
                        <li>
                            <h3>Nb crédits : ${data.credits}</h3>
                        </li>
                    `);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
});

