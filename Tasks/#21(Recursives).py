students = {
    "S101": {
        "Name": "Ahmed",
        "Age": 20,
        "Courses" : {
            "Math":85, "Science":90 , "English":78
        },
        "Address" : {
            "Street":"123 Main Street",
            "City": "Islamabad",
            "State": "CA",
            "ZIP": "12345"
        }
    },
    "S102": {
        "Name": "Bilal",
        "Age": 22,
        "Courses" : {
            "Math":95, "Science":37 , "English":58
        },
        "Address" : {
            "Street":"46 Ghosia Street",
            "City": "Islamabad",
            "State": "CA",
            "ZIP": "051"
        }
    },
    "S103": {
        "Name": "Saim",
        "Age": 20,
        "Courses" : {
            "Math":55, "Science":77 , "English":69
        },
        "Address" : {
            "Street":"Kallar 34 Street",
            "City": "Islamabad",
            "State": "CA",
            "ZIP": "051"
        }
    },
    "S104": {
        "Name": "Zohaib",
        "Age": 20,
        "Courses" : {
            "Math":95, "Science":90 , "English":78
        },
        "Address" : {
            "Street":"45 Adiala Main Street",
            "City": "Islamabad",
            "State": "CA",
            "ZIP": "051"
        }
    }
}
#print(students)
def calculate_average_grade_recursive(students,index =0):
    keys = list(students.keys())
    if index >= len(keys):
        return
    key = keys[index]
    student = students[key]
    name = students["Name"]
    grades = students["Courses"].values()
    average= sum(grades) / len(grades)
    print(f"{name}: {average:.2f}")
    calculate_average_grade_recursive(students , index + 1)


calculate_average_grade_recursive(students)