using DesafioCelularPOO.Models;

Console.WriteLine("Smartphone Nokia:");
Smartphone nokia = new Nokia(numero: "12345678", modelo: "2006", imei: "111111111", memoria: 4);
nokia.Ligar();
nokia.InstalarAplicativo("Whatsapp");
nokia.ApresentaPropriedadesSmartphone();

Console.WriteLine("---------------------------");

Console.WriteLine("Smartphone iPhone:");
Smartphone iphone = new Iphone(numero: "98765432", modelo: "X", imei: "222222222", memoria: 128);
iphone.ReceberLigacao();
iphone.InstalarAplicativo("Telegram");
iphone.ApresentaPropriedadesSmartphone();