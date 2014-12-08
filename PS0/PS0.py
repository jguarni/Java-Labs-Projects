def compute_tax(income, exemptions, non_profit):
    """
    Computes the amount of tax owed for the given income
    level, number of exemptions, and non-profit status.

    income -- number
    exemptions -- number
    non_profit -- boolean

    return -- number
    """
    adjusted_income = income - (exemptions * 5000)
    if non_profit or adjusted_income < 0:
        return 0
    elif adjusted_income < 10000:
        return adjusted_income * .1
    elif adjusted_income < 20000:
        return adjusted_income * .15
    elif adjusted_income < 50000:
        return adjusted_income * .2
    else:
        return adjusted_income * .25

print(compute_tax(30000, 2, False))
print(compute_tax(10000, 6, False))
print(compute_tax(75000, 1, False))
print(compute_tax(75000, 1, True))

def gross_income(income, exemptions, non_profit):
    """
    Computes the gross income (taking into account taxes)
    for the given income level, number of exemptions, and
    non-profit status.

    income -- number
    exemptions -- number
    non_profit -- boolean

    return -- number
    """
    return income - compute_tax(income, exemptions, non_profit)

print(gross_income(30000, 2, False))
print(gross_income(10000, 6, False))
print(gross_income(75000, 1, False))
print(gross_income(75000, 1, True))
