<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./style.css">
    <title>@yield('title')</title>
</head>

<body>
    <header>
        <h1>@yield('title')</h1>
    </header>
    <main>
        @yield('content')
    </main>
</body>

</html>