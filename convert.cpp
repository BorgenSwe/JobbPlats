#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main (int argc, char* argv[])
{
    ifstream infile;
    infile.open (argv[1]);

    ofstream outfile;
    outfile.open(argv[2]);

    string line;
    while (getline(infile, line))
    {
        if (line.find("INSERT INTO role") != string::npos) {
            // ingenting
        }
        else if (line.find("competence ") != string::npos) {
            int startId = line.find("VALUES (")+8;
            int endId = line.find(", ’");
            string id = line.substr(startId, endId-startId);

            int startName = line.find(" ’")+2;
            int endName = line.find("’);");
            string name = line.substr(startName, endName-startName);

            outfile << "INSERT INTO competence (competence_id) VALUES (" << id << ");" << endl;
            outfile << "INSERT INTO localization (word_language, word_translation, competence_for) VALUES ('sv','" << name << "'," << id << ");" << endl;
            outfile << "INSERT INTO localization (word_language, word_translation, competence_for) VALUES ('en','" << name << "'," << id << ");" << endl;
        }
        else {
            outfile << line << endl;
        }
    }
    infile.close();
    outfile.close();
}
