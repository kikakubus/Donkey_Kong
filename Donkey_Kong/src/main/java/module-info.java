module Donkey.Kong {
    requires hanyaeger;



    exports org.example;
    exports org.example.scenes;

    opens Backgrounds;
    opens Sound;
    opens sprites;
}