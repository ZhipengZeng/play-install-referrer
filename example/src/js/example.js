import { OttRemitPlayInstallReferrer } from 'capacitor-play-install-referrer-library';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    OttRemitPlayInstallReferrer.echo({ value: inputValue })
}
