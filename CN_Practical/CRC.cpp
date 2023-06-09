#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    system("cls");
    string message;
    string generator;
    // Input Data Stream
    cout << "Enter message bits: ";

    getline(cin, message);
    cout << "Enter generator: ";

    getline(cin, generator);

    vector<int> data(message.length() + generator.length() - 1);
    vector<int> divisor(generator.length());
    for (int i = 0; i < message.length(); i++)
        data[i] = message[i] - '0';
    for (int i = 0; i < generator.length(); i++)
        divisor[i] = generator[i] - '0';

    // Calculation of CRC
    for (int i = 0; i < message.length(); i++)
    {
        if (data[i] == 1)
        {
            for (int j = 0; j < divisor.size(); j++)
                data[i + j] ^= divisor[j];
        }
    }

    // Display CRC
    cout << "The checksum code is: ";
    for (int i = 0; i < message.length(); i++)
        data[i] = message[i] - '0';
    for (int i = 0; i < data.size(); i++)
        cout << data[i];
    cout << endl;

    // Check for input CRC code
    cout << "Enter checksum code: ";
    getline(cin, message);
    cout << "Enter generator: ";
    getline(cin, generator);

    vector<int> data2(message.length() + generator.length() - 1);
    vector<int> divisor2(generator.length());
    for (int i = 0; i < message.length(); i++)
        data2[i] = message[i] - '0';
    for (int i = 0; i < generator.length(); i++)
        divisor2[i] = generator[i] - '0';

    // Calculation of remainder
    for (int i = 0; i < message.length(); i++)
    {
        if (data2[i] == 1)
        {
            for (int j = 0; j < divisor2.size(); j++)
                data2[i + j] ^= divisor2[j];
        }
    }

    // Display validity of data
    bool valid = true;
    for (int i = 0; i < data2.size(); i++)
    {
        if (data2[i] == 1)
        {
            valid = false;
            break;
        }
    }

    if (valid)
        cout << "Data stream is valid" << endl;
    else
        cout << "Data stream is invalid. CRC error occurred." << endl;

    return 0;
}