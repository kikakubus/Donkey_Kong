module Donkey.Kong {
    requires hanyaeger;



    exports org.example;
    exports org.example.scenes;
    exports org.example.entities.level;
    exports org.example.entities.level.ladders;

    opens Backgrounds;
    opens Sound;
    opens sprites;
}